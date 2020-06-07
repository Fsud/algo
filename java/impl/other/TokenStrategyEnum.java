package impl.other;

import java.util.Date;

public enum TokenStrategyEnum{

    //使用策略枚举
    RANDOM(1),TIMESTAMP(2);
    TokenStrategyEnum(Integer value){
        this.value = value;
    }

    private Integer value;

    public String generate(TokenStrategyEnum e){
        if(e.value == RANDOM.value){
            // 生成策略未实现
            return "";
        }
        if(e.value == TIMESTAMP.value){
            // 生成策略未实现
            return String.valueOf(new Date().getTime());
        }
        return null;
    }
}
