package com.mingle.loadview;

/**
 * Created by zzz40500 on 15/6/21.
 */
public enum ProgressTypeEnum {

    NONE(0),CIRCULAR(1),CIRCULAR2(2),DIALOG(3),GRAYSCALE(4),SHAPE(5),CUSTOM1(6),CUSTOM2(7);
    private  int progressType;


    ProgressTypeEnum(int type){
      progressType=type;
    }


    public int getProgressType() {
        return progressType;
    }


    public static ProgressTypeEnum getProgressType(int type){
        ProgressTypeEnum typeEnum=null;
        switch (type){
            case  0:
                typeEnum=NONE;
                break;
            case  1:
                typeEnum=CIRCULAR;
                break;
            case  2:
                typeEnum=CIRCULAR2;
                break;
            case  3:
                typeEnum=DIALOG;
                break;
            case  4:
                typeEnum=GRAYSCALE;
                break;
            case  5:
                typeEnum=SHAPE;
                break;
            case  6:
                typeEnum=CUSTOM1;
                break;
            case  7:
                typeEnum=CUSTOM2;
                break;
            default:
                typeEnum=NONE;
                break;

        }
        return  typeEnum;
    }

}
