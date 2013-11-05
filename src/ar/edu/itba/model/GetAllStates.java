package ar.edu.itba.model;
import java.util.List;


public class GetAllStates extends ModelObject{
	private Meta meta;
	private List<State> states;//el nombre de la clase no importa, pero el de las variables debe coincidir con el json
	public Meta getMeta() {
		return meta;
	}
	public List<State> getStates() {
		return states;
	}
	@Override
	public String toString() {
		return meta.toString() + states.toString();
	}
}
/*{
"meta": {
"uuid": "22920a89-d641-4598-be7f-0e1dd42cefec",
"time": "18.825ms"
},
"states": [
{
    "stateId": "C",
    "name": "Ciudad Autonoma de Buenos Aires"
},
{
    "stateId": "B",
    "name": "Buenos Aires"
},
...
]
}*/