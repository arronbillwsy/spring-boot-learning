package learn_spring_boot.demo.entity;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 15:12
 **/
public class InitConfig {
    private String config1;
    private String config2;
    private String config3;
    private String name;

    public InitConfig(Builder builder) {
        this.config1 = builder.config1;
        this.config2 = builder.config2;
        this.config3 = builder.config3;
        this.name = builder.name;
    }

    public static Builder options(){
        return new InitConfig.Builder();
    }

    public static class Builder{
        private String config1;
        private String config2;
        private String config3;
        private String name;

        public Builder setConfig1(String config1) {
            this.config1 = config1;
            return this;
        }

        public Builder setConfig2(String config2) {
            this.config2 = config2;
            return this;
        }

        public Builder setConfig3(String config3) {
            this.config3 = config3;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public InitConfig build(){
            return new InitConfig(this);
        }
    }

    public String getConfig1() {
        return config1;
    }

    public String getConfig2() {
        return config2;
    }

    public String getConfig3() {
        return config3;
    }

    public String getName() {
        return name;
    }
}
