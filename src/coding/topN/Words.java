package coding.topN;

class Words implements Comparable<Words>{
    String word ;
    int counts;
    public Words() {
        // TODO Auto-generated constructor stub
    }
    public Words(String word,int counts) {
        // TODO Auto-generated constructor stub
        this.word = word;
        this.counts = counts ;
    }
    //��дcompareTo���������ڱȽ����������С
    @Override 
    public int compareTo(Words w) {
        // TODO Auto-generated method stub
        if(this.counts > w.counts){
            return 1;
        }
        if(this.counts < w.counts){
            return -1;
        }        
        return 0;
    }
    //��дclone��������ƣ�
    @Override
    protected Words clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        Words words = new Words(word,counts);
        return words;
    }
}
