package comparator;
import java.util.Comparator;
import clases.Cmr;

public class PesoComparator implements Comparator<Cmr>{

	public int compare(Cmr arg0, Cmr arg1) {
		if (arg0.getPeso() == arg1.getPeso()){
			return 0;
		} else if (arg0.getPeso() < arg1.getPeso()){
			return -1;
		} else{
			return 1;
		}
		
		
	
	}

}
