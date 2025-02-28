package segTreesCode;

class segmentTreeforMaxElement{
    int[] segmentTreeArr;
    segmentTreeforMaxElement(int size){
        this.segmentTreeArr=new int[4*size];
    }

    public void buildSegTreeForMax(int index,int left,int right,int[] input){
        if (left==right) {
            segmentTreeArr[index]=input[left];
            return;
        }
        int mid=left+(right-left)/2;
        buildSegTreeForMax((index*2)+1, left, mid, input);
        buildSegTreeForMax((index*2)+2, mid+1, right, input);

        segmentTreeArr[index]=Math.max(segmentTreeArr[(2*index)+1], segmentTreeArr[(2*index)+2]);
    }

    public int query(int index,int treeLeft,int treeRight,int givenLeft,int givenRight){
        if (treeLeft>=givenLeft && treeRight<=givenRight) {
            return segmentTreeArr[index];
        }
        if (givenLeft>treeRight || givenRight<treeLeft) {
            return Integer.MIN_VALUE;
        }
        int mid=treeLeft+(treeRight-treeLeft)/2;
        int leftMax=query((2*index)+1, treeLeft, mid, givenLeft, givenRight);
        int rightMax=query((2*index)+2, mid+1, treeRight, givenLeft, givenRight);

        return Math.max(leftMax, rightMax);
    }
}