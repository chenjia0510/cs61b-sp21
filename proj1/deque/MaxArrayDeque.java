package deque;
import java.util.Comparator;


public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator <T> m_tool=null;
    public MaxArrayDeque(){
        super();
    }
    public MaxArrayDeque(Comparator<T> c){
        /** creates a MaxArrayDeque with the given Comparator. */
        super();
        m_tool=c;
    }

    public T max() {
        /**:returns the maximum element in the deque as governed by the previously given Comparator.
        If the MaxArrayDeque is empty, simply return null. **/
        if(super.size()==0){
            return null;
        }
        int max_index=0;
        for (int i=0;i<super.size();i++){
            if(m_tool.compare((get(max_index)),get(i))<0){
                max_index=i;
            }
        }
        return super.get(max_index);

    }

    public T max(Comparator<T> c) {
        /** : returns the maximum element in the deque as governed by the parameter Comparator c.
         // If the MaxArrayDeque is empty, simply return null. **/
        if(super.size()==0){
            return null;
        }
        int max_index=0;
        for (int i=0;i<size();i++){
            if(c.compare((get(max_index)),get(i))<0){
                max_index=i;
            }
        }
        return get(max_index);

    }
}