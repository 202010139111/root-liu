package git;

import java.util.ArrayList;

public class ParkingSystem implements IParking{
    Integer big;
    Integer medium;
    Integer small;
    String str;         //停车返回结果,未处理
    String [] strings;      //停车返回结果，已处理
    public ParkingSystem(Integer big, Integer medium, Integer small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }


    @Override
    public void print() {
        String str = "[";
        for (int i=0;i<strings.length;i++) {
            if (i == strings.length-1) {
                str += strings[i] + "]";
            }
            else {
                str += strings[i] + ",";
            }
        }
        System.out.println(str);
    }

    @Override
    public boolean addCar(int carType) {
        if (carType==1 && big>0) {
            big--;
            parse("true");
            return true;
        }
        else if (carType==2 && medium>0){
            medium--;
            parse("true");
            return true;
        }
        else if (carType==3 && small>0) {
            small--;
            parse("true");
            return true;
        }
        else {
            parse("false");
            return false;
        }
    }

    String[] parse(String input) {

        str += input+" ";
        strings = str.split(" ");
        return strings;
    }

    public static void main(String[] args) throws Exception {
        IParams params = IParking.parse();//ParkingSystem.parse();
        ParkingSystem ps = new ParkingSystem(params.getBig(), params.getMedium(),params.getSmall());
        ArrayList<Integer> plan = params.getPlanParking();
        for (int i = 0; i < plan.size(); i++) {
            ps.addCar(plan.get(i));
        }
        ps.print();

    }

}

