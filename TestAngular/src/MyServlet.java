import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet............");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost............");

		// Enumeration<String> paraNames = request.getParameterNames();
		// while (paraNames.hasMoreElements()) {
		// String nextElement = paraNames.nextElement();
		// System.out.println(nextElement + ":" +
		// request.getParameter(nextElement));
		// }

		String jsonList;
		BufferedReader personList = request.getReader();
		if (personList != null) {
			while ((jsonList = personList.readLine()) != null) {
				System.out.println(jsonList);

				try {
					JSONArray jsonArray = new JSONArray(jsonList);

					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObj = (JSONObject) jsonArray.get(i);

						System.out.println(jsonObj.get("name"));
						System.out.println(jsonObj.get("age"));
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}
}
