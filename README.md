# Weather

String[] nowTemp=new String[3];   * // 온도 *

String[] weatherId = new String[3];   * // Weathercode *

String[] weatherMain=new String[3];   * // 날씨 설명(간략히) *

String[] weatherDescription = new String[3];   * // 날씨 설명(상세히) *

     ex)         String ToString ="nowTemp: "+ getNowTemp()[0]+"\n"

                        +"3hr later: " +getNowTemp()[1]+"\n"
                        
                        +"6hr later: "+getNowTemp()[2]+"\n"
                        
                        +"id: " +getWeatherId()[1]+"\n"
                        
                        +"description: " +getWeatherDescription()[1]+"\n"
                        
                        +"main: " +getWeatherMain()[1]+"\n";


## weather: 3,6,9,12... 시간대별로 예측 날씨 가져온다

> ex) 2:39분에 가져오면 3시부터 3시꺼, 6시꺼, 9시꺼 가져옴


## Weathercode --> 비오는지 여부 알 수 있음
    2XX: Thunderstorm
                
    3XX: Drizzle
                
    5XX: Rain
                
    6XX: Snow
    
### Weather.java 참조
