function getDiscussions() {
    $.get('/discussion/get/all', function (data) {
        let length = data.length;
        for (let i = 0; i < length; i++) {
            let content =
                "<div style='width: 100%;margin-bottom: 2px;display: table;background-color: white;padding-top: 10px'>" +
                "            <div style='width:80%;display: table-cell;padding-left: 20px'>" +
                "                <div style='margin-right: 50px;margin-bottom: 20px;font-weight: bold;font-size: 20px;'>" +
                "                    <label for='inputTitle'></label>" +
                "                    <input id='inputTitle' type='text' style='border: none;width: 100%'" +
                "                           value='" + data[i].title + "'>" +
                "                </div>" +

                "                <div style='margin-right: 50px'>" +
                "                    <label for='textareaContext'></label>" +
                "                    <textarea id='textareaContext'" +
                "                              style='height: 200px;background-color: snow;width: 100%;padding: 10px;border: none;resize: none;'" +
                "                              placeholder='谈谈你的看法'></textarea>" +
                "                </div>" +

                "                <div style='text-align: right;margin-right: 50px'>" +
                "                    <button id='look' type='button' onclick='doLook()'>" +
                "                        看评论" +
                "                    </button>" +
                "                    <button id='submit' type='button' onclick='doSubmit()'>" +
                "                        提交" +
                "                    </button>" +
                "                </div>" +
                "            </div>" +

                "            <div style='width:20%;text-align: center;display: table-cell;'>" +
                "                <img src='/img/profile.png' style='height: 60px;width: 60px;margin-top: 10px' alt='头像'>" +
                "                <input type='hidden' name='username'><br>" +
                "                <label for='inputAlias'></label>" +
                "                <input id='inputAlias' type='text' value='你好，佩奇'" +
                "                       style='border: none;text-align: center;color: gray;font-weight: lighter;padding: 5px'>" +
                "                <label for='inputTime'></label>" +
                "                <input id='inputTime' type='text' value='2021-09-20 21:07:25'" +
                "                       style='border: none;text-align: center;color: gray;font-weight: lighter;padding: 5px'>" +
                "                <div style='margin: 15px;'>" +
                "                    <label>" +
                "                        <p style='font-weight: bold;color: black;border-bottom: silver 2px dotted;padding-bottom: 5px'>看看楼主</p>" +
                "                        <div class='div-userComment' style='overflow: auto;padding-top: 5px;background-color:white;height:100px;width:100%;border: none;resize: none;text-align: left'>" +
                data[i].content +
                "                        </div>" +
                "                    </label>" +
                "                </div>" +
                "            </div>" +
                "</div>";

            $('#div-content').append(content);
            parent.setIframeHeight("external-frame");
        }

    }, 'json')
}

function doLook() {

}


function doSubmit() {
    parent.layer.msg('提交成功', {
        anim: 1,
        time: 1000
    });
}

function serHeight(element) {
    let value = $(element).val();
    if (value.length > 100) {
        let shortValue = value.substr(0, 100);
        $(element).text(shortValue + "...")
    } else {
        $(element).text(value)
    }
    $(element).height(element.scrollHeight);
}

$(function () {
    getDiscussions();
    $('.textarea-userComment').each(function () {
        serHeight(this);
    })
})