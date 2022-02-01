import java.net.URL
import org.json.JSONObject

fun main() {
    println("Текущая температура")
    print("Введи город: ")
    val inputCity: String? = readLine()
    val temp = weatherInCity(inputCity)
    print("Погода в городе $inputCity: $temp")
}
fun weatherInCity(cityName: String?): String {
    val API_KEY = "0cb94b92bd681d0cc1c1f97810e8c4a1"
    val addressURL = "https://api.openweathermap.org/data/2.5/weather?q=$cityName&units=metric&appid=$API_KEY"
    val response = URL(addressURL).readText(Charsets.UTF_8)
    val jsonObj = JSONObject(response)

    return jsonObj.getJSONObject("main").get("temp").toString()
}

