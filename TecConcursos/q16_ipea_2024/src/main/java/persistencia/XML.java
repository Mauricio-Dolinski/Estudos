package persistencia;

public class XML implements Exportavel {
    public boolean open(){
        System.out.println(this.getClass().getName() + " open");
        return true;
    }
    public boolean close(){
        System.out.println(this.getClass().getName() + " close");
        return true;
    }
    public boolean write(String dados){
        System.out.println(this.getClass().getName() + " write");
        return true;
    }
    public boolean read(){
        System.out.println(this.getClass().getName() + " read");
        return true;
    }
}
