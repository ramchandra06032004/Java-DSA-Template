package segTreesCode;

class segTreeForSum {
    int[] segTreeArr;
    segTreeForSum(int size) {
        this.segTreeArr = new int[4 * size];
    }
    //for sum in range
    public void buildSegTreeForSum(int index,int low,int high,int[] input){
        if (low==high) {
            segTreeArr[index]=input[low];
            return;
        }

        int mid=low+(high-low)/2;
        buildSegTreeForSum((2*index)+1, low, mid, input);
        buildSegTreeForSum((2*index)+2, mid+1, high, input);
        
        segTreeArr[index]=segTreeArr[(2*index)+1]+segTreeArr[(2*index)+2];
    }
    public int query(int index,int treeLeft,int treeRight,int givenLeft,int givenRight){
        if (givenLeft<=treeLeft && givenRight>=treeRight) {
            return segTreeArr[index];
        }
        if (givenLeft>treeRight || givenRight<treeLeft) {
            return 0;
        }
        int mid=treeLeft+(treeRight-treeLeft)/2;
        int leftSum=query((2*index)+1, treeLeft, mid, givenLeft, givenRight);
        int rightSum=query((2*index)+2, mid+1, treeRight, givenLeft, givenRight);
        return leftSum+rightSum;
    }  
    public void update(int val,int index,int left,int right,int i){
        if (right==left) {
            segTreeArr[i]=val;
            return;
        }

        int mid=left+(right-left)/2;
        if (index<=mid) {
            update(val, index, left, mid,(i*2)+1);
        }else{
            update(val, index, mid+1, right, (i*2)+2);
        }
        segTreeArr[i]=segTreeArr[(i*2)+1]+segTreeArr[(i*2)+2];
    }
    public static void main(String[] args) {
        segTreeForSum s=new segTreeForSum(5);
        s.buildSegTreeForSum(0, 0, 4, new int[]{26, 30, 48, 29, 8});
        System.out.println(s.query(0, 0, 4, 4, 4));
        System.out.println(s.query(0, 0, 4, 2, 3));
        //{4, 4, 2, 3}));
    }
}

