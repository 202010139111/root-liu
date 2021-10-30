package git;

import java.util.ArrayList;
import java.util.Scanner;

public interface IParking {
    // 打印输出结果
    public void print();
    // 检查是否有 carType 对应的停车位
    // 如果没有空车位，请返回 false ，否则将该车停入车位并返回 true
    public boolean addCar(int carType);
    // 解析命令行输入的参数（格式），如文档描述
    public static IParams parse() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Scanner sc = new Scanner(str);
        sc.useDelimiter("\\D+");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            arrayList.add(Integer.parseInt(sc.next()));
        }
        //System.out.println(arrayList);
        IParams iParams = new IParams() {
            Integer big = arrayList.get(0);
            Integer medium = arrayList.get(1);
            Integer small = arrayList.get(2);

            @Override
            public int getBig() {
                return big;
            }

            @Override
            public int getMedium() {
                return medium;
            }

            @Override
            public int getSmall() {
                return small;
            }

            @Override
            public ArrayList<Integer> getPlanParking() {
                ArrayList<Integer> array = new ArrayList<Integer>();
                for (int i=3;i<arrayList.size();i++) {
                    array.add(arrayList.get(i));
                }
                //System.out.println(array);
                return array;
            }
        };

 	    return iParams;
    };

}
