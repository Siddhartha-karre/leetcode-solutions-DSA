class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xC=0, yC=0;
        if(xCenter<x1) xC=x1;
        else if(xCenter>x2) xC=x2;
        else xC=xCenter;

        if(yCenter<y1) yC=y1;
        else if(yCenter>y2) yC=y2;
        else yC=yCenter;

        return ((xC-xCenter)*(xC-xCenter)+(yC-yCenter)*(yC-yCenter)) <= radius*radius;
    }
}