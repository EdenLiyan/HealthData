package util;

/**
 * Created by liyan on 2020/10/21.
 */

public class TestUtil {

    private float fat;
    private float bmi;
    private float viscera;

    public String weightTestUtil(String s) {

        String weightResult = null;
        bmi = Float.parseFloat(s);

        if (bmi <= 18.4) {

            weightResult = "体重偏低" + "\n" + "您有些营养不良。";

        } else if (bmi > 18.4 && bmi <= 24.9) {

            weightResult = "标准体重" + "\n" + "完美身材，继续保持。";

        } else if (bmi > 24.9 && bmi <= 29.9) {

            weightResult = "肥胖（1度）" + "\n" + "您现在处于轻微肥胖状态。";

        } else if (bmi > 29.9 && bmi <= 34.9) {

            weightResult = "肥胖（2度）" + "\n" + "您现在处于肥胖状态。";

        } else if (bmi > 34.9 && bmi <= 39.9) {

            weightResult = "肥胖（3度）" + "\n" + "您现在处于高度肥胖状态。";

        } else {

            weightResult = "肥胖（4度）" + "\n" + "您现在处于严重肥胖的状态。";

        }


        return weightResult;
    }

    public String fatTestUtil(String s, String sex) {

        String fatResult = null;
        fat = Float.parseFloat(s);

        if (sex.equals("男")) {

            if (fat >= 5.0 && fat <= 9.9) {

                fatResult = "低" + "\n" + "建议您多吃肉食、牛奶以及高营养的食物来增强体质。";

            } else if (fat > 9.9 && fat <= 19.9) {

                fatResult = "标准" + "\n" + "您的脂肪属于标准比例，继续保持。";

            } else if (fat > 19.9 && fat <= 24.9) {

                fatResult = "偏高" + "\n" + "建议您少吃高热量食物，多吃果蔬，多加运动。";

            } else {

                fatResult = "高" + "\n" + "建议您尽早制定健身计划，注意饮食，以免影响身心健康。";

            }

        } else {

            if (fat >= 5.0 && fat <= 19.9) {

                fatResult = "低" + "\n" + "建议您多吃肉食、牛奶以及高营养的食物来增强体质。";

            } else if (fat > 19.9 && fat <= 29.9) {

                fatResult = "标准" + "\n" + "您的脂肪属于标准比例，继续保持。";

            } else if (fat > 29.9 && fat <= 34.9) {

                fatResult = "偏高" + "\n" + "建议您少吃高热量食物，多吃果蔬，多加运动。";

            } else {

                fatResult = "高" + "\n" + "建议您尽早制定健身计划，注意饮食，以免影响身心健康。";

            }

        }

        return fatResult;

    }

    public String visceraTestUtil(String s) {

        String visceraResult = null;
        viscera = Float.parseFloat(s);

        if (viscera >= 0.5 && viscera <= 9.5) {

            visceraResult = "标准" + "\n" + "您的内脏脂肪面积为"+viscera * 10 + "平方厘米，属于正常范围之内，请继续保持。";

        } else if (viscera > 9.5 && viscera <= 14.5) {

            visceraResult = "偏高" + "\n" + "您的内脏脂肪面积为"+viscera * 10 + "平方厘米，建议您多做运动，少吃油腻食物，少吃肉类，多吃果蔬。";

        } else {

            visceraResult = "高" + "\n" + "您的内脏脂肪面积为"+viscera * 10 + "平方厘米，建议您去医院做详细的体检。";

        }

        return visceraResult;
    }

}
