function verifyCode(selector, width, height) {
    //生成随机数
    function randomNum(min, max) {
        return parseInt(Math.random() * (max - min) + min);
    }

    //生成随机颜色
    function randomColor(min, max) {
        let r = randomNum(min, max), g = randomNum(min, max), b = randomNum(min, max);
        return `rgb(${r},${g},${b})`;
    }

    const canvas = document.querySelector(selector);
    let ctx = canvas.getContext('2d');
    //在canvas上绘制背景颜色
    ctx.fillStyle = randomColor(180, 230);
    ctx.fillRect(0, 0, width, height);

    //随机字符串
    let pool = '1234567890';
    let result = "";//验证码结果
    for (let i = 0; i < 4; i++) {
        let c = pool[randomNum(0, pool.length)];
        let fontSize = randomNum(18, 40);//大小
        let fontDeg = randomNum(-30, 30);//旋转
        ctx.font = fontSize + 'px Simhei';
        ctx.textBaseline = 'top';
        ctx.fillStyle = randomColor(80, 150);//字体填充色
        ctx.save();
        ctx.translate(30 * i + 15, 15);
        ctx.rotate(fontDeg * Math.PI / 180);
        ctx.fillText(c, -10, -10);
        ctx.restore();
        result += c;//验证码结果
    }

    //生成干扰线
    for (let i = 0; i < 5; i++) {
        ctx.beginPath();
        ctx.moveTo(randomNum(0, width), randomNum(0, height));
        ctx.lineTo(randomNum(0, width), randomNum(0, height));
        ctx.strokeStyle = randomColor(180, 230);
        ctx.closePath();
        ctx.stroke();
    }

    //生成干扰点
    for (let i = 0; i < 40; i++) {
        ctx.beginPath();
        ctx.arc(randomNum(0, width), randomNum(0, height), 1, 0, 2 * Math.PI);
        ctx.closePath();
        ctx.fillStyle = randomColor(150, 200);
        ctx.fill();
    }

    return result;
}


