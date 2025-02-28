public class DisjointSet {
    public int[] size;
    public int[] parent;
    public int components;
    public DisjointSet(int nodes){
        this.size=new int[nodes];
        this.parent=new int[nodes];
        this.components=nodes;
        for(int i=0 ; i<nodes ; i++){
            size[i]=1;
            parent[i]=i;
        }

    }
    public int findParent(int node){
        if (parent[node]==node) {
            return node;
        }
        parent[node]=findParent(parent[node]);
        return parent[node];
    }
    public void unionBySize(int node1,int node2){
        int parentNode1=parent[node1];
        int parentNode2=parent[node2];
        if (parentNode1==parentNode2) {
            return;
        }
        components--;
        if (size[parentNode1]<size[parentNode2]) {
            parent[parentNode1]=parentNode2;
            size[parentNode2]+=size[parentNode1];
        }else{
            parent[parentNode2]=parentNode1;
            size[parentNode1]+=size[parentNode2];
        }
    }
}

