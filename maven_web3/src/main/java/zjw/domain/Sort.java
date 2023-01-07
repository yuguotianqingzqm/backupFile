package zjw.domain;

public class Sort {
    private String sortId;
    private String sortName;

    @Override
    public String toString() {
        return "Sort{" +
                "sortId='" + sortId + '\'' +
                ", sortName='" + sortName + '\'' +
                '}';
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortId() {
        return sortId;
    }

    public String getSortName() {
        return sortName;
    }
}
