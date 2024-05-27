package pojo;

public class CatfctNinja_pojo {
    int limit;
    int max_lenght;
    String breed;
    String country;
    String origin;
    String coat;
    String pattern;


    public CatfctNinja_pojo() {

    }

    public CatfctNinja_pojo(int limit, int max_lenght) {
        this.limit = limit;
        this.max_lenght = max_lenght;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getMax_lenght() {
        return max_lenght;
    }

    public void setMax_lenght(int max_lenght) {
        this.max_lenght = max_lenght;
    }
}
