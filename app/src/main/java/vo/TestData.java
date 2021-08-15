package vo;

/**
 * Created by liyan on 2020/10/29.
 */

public class TestData {

    public int id;
    public String tSex;
    public String tWeight;
    public String tFat;
    public String tAge;
    public String tBmi;
    public String tMetabolism;
    public String tViscera;

    public TestData() {
        super();
    }


    public TestData(String weight, String fat, String age, String bmi, String metabolism, String viscera) {
        super();
    }

    public TestData(int id, String sex, String weight, String fat, String age, String bmi, String metabolism, String viscera) {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public String gettWeight() {
        return tWeight;
    }

    public void settWeight(String tWeight) {
        this.tWeight = tWeight;
    }

    public String gettFat() {
        return tFat;
    }

    public void settFat(String tFat) {
        this.tFat = tFat;
    }

    public String gettAge() {
        return tAge;
    }

    public void settAge(String tAge) {
        this.tAge = tAge;
    }

    public String gettBmi() {
        return tBmi;
    }

    public void settBmi(String tBmi) {
        this.tBmi = tBmi;
    }

    public String gettMetabolism() {
        return tMetabolism;
    }

    public void settMetabolism(String tMetabolism) {
        this.tMetabolism = tMetabolism;
    }

    public String gettViscera() {
        return tViscera;
    }

    public void settViscera(String tViscera) {
        this.tViscera = tViscera;
    }
}
