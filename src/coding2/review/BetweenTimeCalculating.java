package coding2.review;

import java.util.Date;

/**
 * @author alenlyx
 */
public class BetweenTimeCalculating {

    public static void main(String[] args) throws InterruptedException {
        Date startDate = new Date();
        System.out.println(startDate.toString());
        Thread.sleep(5000);
        Date endDate = new Date();
        System.out.println(endDate.toString());
        int s= BetweenTimeCalculating.getBetweenSecond(startDate,endDate);
        System.out.println(s);
    }

    public static Integer getBetweenSecond(Date startDate, Date endDate) {
        Integer seconds = 0;
        try {
            if(startDate!=null&&endDate!=null) {
                long ss = 0;
                if(startDate.before(endDate)) {
                    ss = endDate.getTime() - startDate.getTime();
                }else {
                    ss = startDate.getTime() - endDate.getTime();
                }
                seconds = Integer.valueOf((int) (ss/(1000))) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seconds;
    }
}
