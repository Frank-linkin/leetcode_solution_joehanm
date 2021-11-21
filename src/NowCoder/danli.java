package NowCoder;

public class danli {
    String s = null;

    public danli(){
        this.s = null;
    }
    public String  getDanli(String s ){
        if(this.s == null){
            synchronized (danli.class){
                this.s = new String();
            }
        }
        return this.s;
    }
}

