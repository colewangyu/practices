package ICBC;import java.util.*;

public class Allocation {

    public Map<String, List<String>> allocation(List<String> ID, Map<String, Integer> weight) {
        Map<String, List<String>> allocation = new HashMap<String, List<String>>();
        //计算权重总和并创建派单列表
        int sumWeight  = 0;
        Iterator<String> it = weight.keySet().iterator();
        while(it.hasNext()) {
            String tmpKey = it.next();
            int tmpValue = weight.get(tmpKey);
            sumWeight += tmpValue;
            allocation.put(tmpKey, new ArrayList<String>());
        }
        // 判断是否可以派单
        if(ID.size() < sumWeight) {
            // 工单不足，不派单
            return null;
        }
        //进行派单
        int indexOfID = 0;
        int sizeOfID = ID.size();
        while(sizeOfID >= sumWeight) {
            sizeOfID -= sumWeight;
            it = allocation.keySet().iterator();
            while(it.hasNext()) {
                String tmpKey = it.next();
                List<String> tmpValue = allocation.get(tmpKey);
                int tmpWeight = weight.get(tmpKey);
                while(tmpWeight > 0) {
                    tmpValue.add(ID.get(indexOfID));
                    indexOfID++;
                    tmpWeight--;
                }
            }
        }

        return allocation;
    }
}

