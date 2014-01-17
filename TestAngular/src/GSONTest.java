import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class GSONTest {

	public static void main(String[] args) {

		BagOfPrimitives bag = new BagOfPrimitives();

		Gson gson = new Gson();
		String jsonStr = gson.toJson(bag);
		System.out.println(jsonStr);

		BagOfPrimitives bag2 = gson.fromJson(jsonStr, BagOfPrimitives.class);
		System.out.println(bag2.value2);

		// ---------------------------

		A a = new A();
		jsonStr = gson.toJson(a);
		System.out.println(jsonStr);

		A a2 = gson.fromJson(jsonStr, A.class);
		System.out.println(a2.bag.value3);
		System.out.println(a2.bag.names[1]);

		// ---------------------------

		try {
			JSONObject jsonObject = new JSONObject(jsonStr);

			System.out.println(jsonObject);

			System.out.println(jsonObject.getJSONObject("bag"));
			System.out.println(jsonObject.getJSONObject("bag").getInt("value1"));
			System.out.println(jsonObject.getJSONObject("bag").getString("value2"));
			System.out.println(jsonObject.getJSONObject("bag").getJSONArray("names").get(0));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class A {
	public BagOfPrimitives bag = new BagOfPrimitives();
}

class BagOfPrimitives {
	public int value1 = 1;
	public String value2 = "abc";
	public int value3 = 3;
	public String[] names = { "koh", "miho" };

	BagOfPrimitives() {
		// no-args constructor
	}
}
