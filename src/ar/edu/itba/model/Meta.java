package ar.edu.itba.model;

public class Meta {
 private String uuid;
 private String time;
public String getUuid() {
	return uuid;
}
public String getTime() {
	return time;
}

@Override
	public String toString() {
		return uuid + time;
	}
}
/*"meta": {
"uuid": "22920a89-d641-4598-be7f-0e1dd42cefec",
"time": "18.825ms"
}*/