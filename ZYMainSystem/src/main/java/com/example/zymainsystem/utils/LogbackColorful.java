package com.example.zymainsystem.utils;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 * TODO Logback自定义级别颜色
 *
 * @Author : WuXian
 * @Time : 2021/7/26 9:17
 */
public class LogbackColorful extends ForegroundCompositeConverterBase<ILoggingEvent> {
    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        Level level = event.getLevel();
        switch (level.toInt()) {
            //ERROR等级为红色
            case Level.ERROR_INT:
                return ANSIConstants.RED_FG;
            //WARN等级为黄色
            case Level.WARN_INT:
                return ANSIConstants.YELLOW_FG;
            //INFO等级为蓝色
            case Level.INFO_INT:
                return ANSIConstants.GREEN_FG;
            //DEBUG等级为绿色
            case Level.DEBUG_INT:
                return ANSIConstants.BLACK_FG;
            //其他为默认颜色
            default:
                return ANSIConstants.DEFAULT_FG;
        }
    }
}
