import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution126 {
    class MapNode{
        public String word;
        public MapNode[] links;
        public int linksLen;
        public boolean visited;
        public List<String> path;

        public MapNode(int size){
            this.links = new MapNode[size];
            this.linksLen = 0;
            this.visited = false;
        }


    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<List<String>> resp = new LinkedList<>();

        int endWordIndex = -1;
        int sIndex = -1;
        for(int i =0 ;i<wordList.size();i++){
            if(wordList.get(i).equals(endWord)){
                endWordIndex=i;
            }
            if(canTransfer(beginWord,wordList.get(i))){
                sIndex = i;
            }
        }
        if(endWordIndex==-1||sIndex==-1){
            return resp;
        }

        //建图
        HashMap<String,MapNode> map =new HashMap<>();
        for(int i = 0 ; i< wordList.size()-1;i++){
            String curI = wordList.get(i);
            MapNode curNode  = null;
            if(map.containsKey(curI)){
                curNode = map.get(curI);
            }else{
                curNode = new MapNode(wordList.size());
                curNode.word = curI;
                map.put(curI,curNode);
            }

            for(int j = i+1;j<wordList.size();j++){
                if(canTransfer(curI,wordList.get(j))){
                    String curJ = wordList.get(j);
                    MapNode curJNode;

                    if(map.containsKey(curJ)){
                        curJNode = map.get(curJ);
                    }else{
                        curJNode = new MapNode(wordList.size());
                        map.put(curJ,curJNode);
                        curJNode.word = curJ;
                    }

                    curNode.links[curNode.linksLen]=curJNode;
                    curNode.linksLen++;
                    curJNode.links[curJNode.linksLen]=curNode;
                    curJNode.linksLen++;
                }
            }
        }

        LinkedList<String> path = new LinkedList<>();
        path.add(beginWord);
        for(String word:wordList){
            if(canTransfer(word,beginWord)){
                dfs(map.get(word),map.get(endWord),path,resp);
            }
        }
        return resp;
    }

    public boolean canTransfer(String origin,String target){
        int count = 0;
        for(int i = 0; i< origin.length();i++){
            if(origin.charAt(i)!=target.charAt(i)){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }

    public void dfs(MapNode curNode,MapNode targetNode,LinkedList<String> path,List<List<String>> resp){
        path.add(curNode.word);
        curNode.visited = true;

        if(curNode == targetNode){
            addToResp(path,resp);
        }

        if(curNode.linksLen>0){
            for(int i = 0 ; i< curNode.linksLen;i++){
                if(!curNode.links[i].visited){
                    dfs(curNode.links[i],targetNode,path,resp);
                }
            }
        }

        curNode.visited = false;
        path.pollLast();
    }

    public void bfs(MapNode originNode,MapNode targetNode,LinkedList<String> path,List<List<String>> resp){
        LinkedList<MapNode> queue = new LinkedList<>();
        queue.add(originNode);
        while(!queue.isEmpty()){
            
        }
    }

    public void addToResp(List<String> path,List<List<String>> resp){
        if(resp.size()==0){
            resp.add(new LinkedList<>(path));
            return;
        }

        for(List<String> list:resp){
            if(list.size()>path.size()){
                resp.clear();
                break;
            }
            if(list.size()<path.size()){
                return;
            }
        }
        resp.add(new LinkedList<>(path));
    }
    /**
     * 方法一：
     *  使用图，复杂度O(n2)
     *  一个map,用来记录word和MapNode的对应关系，如果没有这个key，新建
     *  对于每个word,检查之后所有的word，如果是可以进行转换的word,考虑i,j
     *      curNode = map.get(wordlist[i])
     *
     *      if map.containsKey(j){
     *          curNode.Links[len] = map.get(wordlist[j]);
     *      }else{
     *          curNode.Links[len] = new MapNode();
     *          map.put(wordList[j],curNode.Links[len])
     *      }
     *      len++;
     *
     *  生成图之后，进行计算最短距离的操作。
     *  if beginWord没法转换成任何一个阶段||endWord不存在wordList中||endWord.linksLen==0
     *      没有路径
     *  beginWord可以转换的结点为s,寻找s到endWord的最短距离。
        深度优先和广度优先随意
     */

    @Test
    public void test1(){
        LinkedList<Integer> cur = new LinkedList<>();
        cur.add(1);
        cur.add(2);
        cur.add(3);

        cur.poll();
        System.out.println(cur.toString());
    }

}
