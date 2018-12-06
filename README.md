# Weather
weather
3,6,9,12... 시간대별로 예측 날씨 가져온다
ex) 2:39분에 가져오면 3시부터

Temp
Weather
Description
Weathercode --> 비오는지 여부 알 수 있음
                2XX: Thunderstorm
                3XX: Drizzle
                5XX: Rain
                6XX: Snow
String[] nowTemp=new String[3];   *italic* // 온도 
String[] weatherId = new String[3];   *italic* // Weathercode
String[] weatherMain=new String[3];   *italic* // 날씨 설명(간략히)
String[] weatherDescription = new String[3];   *italic* // 날씨 설명(상세히)
