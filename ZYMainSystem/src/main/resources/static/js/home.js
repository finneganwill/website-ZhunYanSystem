function getContent() {
    $.get('/issue/get', function (data) {
        let length = data.length
        for (let i = 0; i < length; i++) {
            let content =
                "<div class='item' style='background-color: white;border-bottom: whitesmoke 2px solid'>" +
                "   <div class='div-content-header' style='padding-top: 15px;padding-left: 15px;border-left: darkslategrey 2px solid'>" +
                "       <div class='header-title' style='padding-bottom:10px;font-weight: bold;font-size: 18px;color: black;'>" +
                data[i].title +
                "       </div>" +
                "       <div class='header-info ' style='color: dimgray;font-size: 12px'>" +
                data[i].tag + " | " + data[i].subject + " | " + data[i].category + " | " + data[i].major +
                "       </div>" +
                "   </div>" +
                "   <div class='div-content-body' style='padding:18px'>" +
                "       <div class='body-text' style='max-height:100px;overflow:hidden'>" +
                data[i].content +
                "       </div>" +
                "       <div class='body-more' style='text-align: left;padding-top: 10px;'>" +
                "           <a href='https://www.baidu.com' style='color: #2D93CA;' target='_parent'>" +
                "               <i class='icon-extend icon-extend-arrow-down'></i> 更多..." +
                "           </a>" +
                "       </div>" +
                "   </div>" +
                "   <div class='div-content-footer' style='padding: 15px;display: table-cell;'>" +
                "       <i class='icon-extend icon-extend-good' style='font-size:20px;display: table-cell;color: cornflowerblue'" +
                "                       onclick='doLike(" + data[i].likeNum + "," + data[i].id + ")'><p style='display: inline;font-size: 15px;margin-right: 20px'> " + data[i].likeNum + "</p></i>" +
                "       <i class='icon-extend icon-extend-shoucang' style='font-size:20px;display: table-cell;color: darkslategray'" +
                "                       onclick='doClt(" + data[i].cltNum + "," + data[i].id + ")'><p style='display: inline;font-size:15px;margin-right: 20px'> " + data[i].cltNum + "</p></i>" +
                "   </div>" +
                "</div>";

            $('#div-content').append(content)
            parent.setIframeHeight("external-frame");
        }
    }, 'json')
}

function doLike(num, id) {
    num += 1;
    $.post('/issue/like', {
        id: id,
        likeNum: num
    }, function (data) {
        if (data) {
            alert("点赞成功");
            parent.location.reload();
        } else {
            alert("点赞失败");
        }
    }, 'json')
}

function doClt(num, id) {
    let username = window.parent.parentToChildValue('hidden-username')
    num += 1;
    $.post('/issue/collect', {
        id: id,
        cltNum: num,
        username: username
    }, function (data) {
        if (data) {
            alert("成功加入题库");
            parent.location.reload();
        } else {
            alert("您已收藏，请勿重复操作");
        }
    }, 'json')
}


$(function () {
    getContent();
    $('#btn-more').click(function () {
        getContent();
    })

})