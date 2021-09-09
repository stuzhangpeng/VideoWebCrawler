/*
* fileuploader.js
*
* */
//获得表单数据
let videoData=new Object();

WebUploader.Uploader.register({
        "before-send-file": "beforeSendFile",
        "before-send": "beforeSend",
        "after-send-file": "afterSendFile"
    }, {
        beforeSendFile: function (file) {
            videoData.uid = jQuery("input[name='uid']").val();
            videoData.name = jQuery("input[name='name']").val();
            videoData.role = jQuery("input[name='role']").val();
            videoData.title = jQuery("input[name='title']").val();
            videoData.open = jQuery("input[name='open']").val();
            videoData.quality = jQuery("#quality option:selected").val();
            videoData.uploadtime = jQuery("input[name='uploadtime']").val();
            videoData.category = jQuery("#type option:selected").val();
            videoData.picturefile = "http://192.168.0.180/group1/M00/00/00/wKgAtF5BCmCACkf8AAF9LRUFlbU197.jpg";
            // 创建一个deffered,用于通知是否完成操作
            var deferred = WebUploader.Deferred();
            // 计算文件的MD5值，用于断点续传和妙传
            (new WebUploader.Uploader()).md5File(file, 0, 50 * 1024 * 1024)
                .then(function (val) {
                    //执行ajax询问客户端是否存在该文件
                    videoData.filemd5 =val,
                        jQuery.ajax({
                            type: "POST",
                            url: "/registerUpload",
                            data: videoData,
                            success: function (data) {
                                if (data.present) {
                                    //文件存在，拒绝上传
                                    $('#' + file.id).find('p.state').text(data.message);
                                    deferred.reject();
                                } else {
                                    //文件不存在开始上传
                                    deferred.resolve();
                                }

                            }
                        });

                });
            // 返回deferred，通知回调函数处理
            return deferred.promise();
        },
        beforeSend: function (block) {
            let deferred = WebUploader.Deferred();
            jQuery.ajax({
                type: "POST",
                url: "/checkChunk",
                data: {
                    id:block.id,
                    fileMD5:videoData.filemd5,
                    // 当前分块下标
                    chunk:block.chunk
                },
                success: function (data) {
                    if (data.present) {
                        //文件存在，拒绝上传
                        deferred.reject();
                    } else {
                        //文件不存在开始上传
                        deferred.resolve();
                    }

                }
            });
            // 发送文件md5字符串到后台
            this.owner.options.formData=videoData;
            return deferred.promise();
        },
        afterSendFile: function (file) {
            videoData.id=file.id;
            videoData.fileName=file.name;
            jQuery.ajax({
                type: "POST",
                url: "/mergeFile",
                data: videoData,
                success: function (data) {
                    $('#' + file.id).find('p.state').text(data.message);
                }
            });
        }
    }
);
//初始化 WebUploader
let uploader = WebUploader.create({
    // swf文件路径
    swf: "/webuploader/Uploader.swf",
    // 文件接收服务端。
    server: "uploadFile",
    // 制定上传按钮以及支持多选.
    pick: {id: "#picker", multiple: true},
    method: 'POST',
    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
    resize: false,
    chunked: true,//分片
    chunkSize: 5242880 * 10,//每片大小50mb
    chunkRetry: 2,//上传失败后尝试次数
    fileVal: 'videoFile',//file域name值
    disableGlobalDnd: true,//禁用全局拖拽
    fileNumLimit: 3,//文件个数
    fileSizeLimit: 15360 * 1048576,//总大小限制15g
    fileSingleSizeLimite: 5120 * 1048576,//单文件大小限制5g
    threads: 3,//并发数目
    prepareNextFile: true,
    accept: {
        title: 'video',
        extensions: 'mp4,ogg,m3u8,webm',
        mimeTypes: 'video/*,application/octet-stream'
    }
});
//注册command

// 加载图片显示缩略图
uploader.on('fileQueued', function (file) {
    let $li = $(
        '<div id="' + file.id + '" class="file-item thumbnail">' +
        '<img>' +
        '<div class="info">' + file.name + '</div>' + '<p class="state" style="color: red">等待上传...</p>' +
        '</div>'
        ),
        $img = $li.find('img');
    // $list为容器jQuery实例
    $("#pictureList").append($li);
    // 创建缩略图
    // 如果为非图片文件，可以不用调用此方法。
    // thumbnailWidth x thumbnailHeight 为 100 x 100
    uploader.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>该文件不能预览</span>');
            return;
        }
        $img.attr('src', src);
    }, 110, 110);
});
//上传文件显示进度条
uploader.on('uploadProgress', function (file, percentage) {
    let $li = $('#' + file.id),
        $percent = $li.find('.progress .progress-bar');
    // 避免重复创建
    if (!$percent.length) {
        $percent = $('<div class="progress progress-striped active">' +
            '<div class="progress-bar" role="progressbar" style="width: 0%">' +
            '</div>' +
            '</div>').appendTo($li).find('.progress-bar');
    }
    $li.find('p.state').text('上传中');
    $percent.css('width', percentage * 100 + '%');
});
uploader.on('uploadSuccess', function (file) {
    $('#' + file.id).find('p.state').text('上传成功');
});
/*// 文件上传失败，显示上传出错
uploader.on('uploadError', function (file) {
    $('#' + file.id).find('p.state').text('上传失败');
});*/
// 完成上传完了，成功或者失败，先删除进度条。
uploader.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});
//发送数据前封装数据
/*uploader.on('uploadBeforeSend', function (obj, data, header) {
    data=videoData;
});*/
/*//接收服务器端返回值
uploader.on("uploadAccept", function (data) {
    if (data.msg === "上传成功") {
        //文件上传成功
        console.log(data.fileId + "上传成功");
    }
});*/
jQuery('#submitBtn').click(
    function () {
        //上传
        uploader.upload();
    }
);
jQuery('#resetBtn').click(
    function () {
        //重置
        uploader.reset();
    }
);