package com.bawka;


import com.bawka.Service.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Solution{

    public static void main (String[] args) throws Exception {
        UserService userService = new UserService();
        String json = "{\"pagination\": {\"next_min_id\": \"AQDifRGkmvPiitpo4JVGL0i6nwKSplQjjnD5p1VM9I1j3pro4bNLQwyshONLxVZ6F9es8FCZ0Qu_gyVq1ASbqHdbwtKWQqxqT10SsVltzUIzng\", \"min_tag_id\": \"AQDifRGkmvPiitpo4JVGL0i6nwKSplQjjnD5p1VM9I1j3pro4bNLQwyshONLxVZ6F9es8FCZ0Qu_gyVq1ASbqHdbwtKWQqxqT10SsVltzUIzng\", \"deprecation_warning\": \"next_max_id and min_id are deprecated for this endpoint; use min_tag_id and max_tag_id instead\"}, \"data\": [{\"id\": \"1721724908675097450_261217117\", \"user\": {\"id\": \"261217117\", \"full_name\": \"bawka\", \"profile_picture\": \"https://scontent.cdninstagram.com/vp/f7565d17e113f6c9a4353adb06a42c47/5B363A7A/t51.2885-19/s150x150/17265847_1313699322044045_2293731892928708608_a.jpg\", \"username\": \"bawka1987\"}, \"images\": {\"thumbnail\": {\"width\": 150, \"height\": 150, \"url\": \"https://scontent.cdninstagram.com/vp/1243a09eb12ea0797a6bfd930071fa66/5B44D4DC/t51.2885-15/s150x150/e35/28156608_2083415891902139_5436360099067068416_n.jpg\"}, \"low_resolution\": {\"width\": 320, \"height\": 320, \"url\": \"https://scontent.cdninstagram.com/vp/7e3869917b90bf818189d0316d30ee95/5B4804EC/t51.2885-15/s320x320/e35/28156608_2083415891902139_5436360099067068416_n.jpg\"}, \"standard_resolution\": {\"width\": 640, \"height\": 640, \"url\": \"https://scontent.cdninstagram.com/vp/3fc552ee09f3d2675497a164024c3532/5B1282A1/t51.2885-15/s640x640/sh0.08/e35/28156608_2083415891902139_5436360099067068416_n.jpg\"}}, \"created_time\": \"1519465624\", \"caption\": {\"id\": \"17932765732055989\", \"text\": \"\\u0428\\u0438\\u043a\\u0430\\u0440\\u043d\\u0435\\u0439\\u0448\\u0438\\u0439 \\u043f\\u043e\\u0434\\u0430\\u0440\\u043e\\u043a \\u043e\\u0442 \\u043b\\u044e\\u0431\\u0438\\u043c\\u043e\\u0439 @m_vysheneba #\\u043a\\u0440\\u0430\\u0444\\u0442\\u044d\\u0442\\u043e\\u043b\\u044e\\u0431\\u043e\\u0432\\u044c #\\u0431\\u043e\\u043a\\u0430\\u043b\\u044b #apa\", \"created_time\": \"1519465624\", \"from\": {\"id\": \"261217117\", \"full_name\": \"bawka\", \"profile_picture\": \"https://scontent.cdninstagram.com/vp/f7565d17e113f6c9a4353adb06a42c47/5B363A7A/t51.2885-19/s150x150/17265847_1313699322044045_2293731892928708608_a.jpg\", \"username\": \"bawka1987\"}}, \"user_has_liked\": false, \"likes\": {\"count\": 39}, \"tags\": [\"\\u043a\\u0440\\u0430\\u0444\\u0442\\u044d\\u0442\\u043e\\u043b\\u044e\\u0431\\u043e\\u0432\\u044c\", \"\\u0431\\u043e\\u043a\\u0430\\u043b\\u044b\", \"apa\"], \"filter\": \"Clarendon\", \"comments\": {\"count\": 1}, \"type\": \"image\", \"link\": \"https://www.instagram.com/p/Bfky66uhWNqfvgI49fYyS9O32jxokp29y59EuI0/\", \"location\": null, \"attribution\": null, \"users_in_photo\": []}, {\"id\": \"1569470388348799830_261217117\", \"user\": {\"id\": \"261217117\", \"full_name\": \"bawka\", \"profile_picture\": \"https://scontent.cdninstagram.com/vp/f7565d17e113f6c9a4353adb06a42c47/5B363A7A/t51.2885-19/s150x150/17265847_1313699322044045_2293731892928708608_a.jpg\", \"username\": \"bawka1987\"}, \"images\": {\"thumbnail\": {\"width\": 150, \"height\": 150, \"url\": \"https://scontent.cdninstagram.com/vp/bc3c3e48013382306cfadadacab5154c/5B468AC9/t51.2885-15/s150x150/e35/20479367_183234185550604_6831432963628990464_n.jpg\"}, \"low_resolution\": {\"width\": 320, \"height\": 320, \"url\": \"https://scontent.cdninstagram.com/vp/186ca99dcabcd451b16a95ef9af83822/5B144F8E/t51.2885-15/s320x320/e35/20479367_183234185550604_6831432963628990464_n.jpg\"}, \"standard_resolution\": {\"width\": 640, \"height\": 640, \"url\": \"https://scontent.cdninstagram.com/vp/583160b8f9a2c680a663695ba155a357/5B43E7CD/t51.2885-15/s640x640/sh0.08/e35/20479367_183234185550604_6831432963628990464_n.jpg\"}}, \"created_time\": \"1501315471\", \"caption\": {\"id\": \"17876379076094553\", \"text\": \"\\u0423\\u0434\\u0438\\u0432\\u0438\\u0442\\u0435\\u043b\\u044c\\u043d\\u043e, \\u043d\\u043e \\u043c\\u043d\\u0435 \\u0432\\u043a\\u0443\\u0441\\u043d\\u043e) \\u0447\\u0435\\u0441\\u0442\\u043d\\u044b\\u0439 \\u0433\\u0440\\u0435\\u0439\\u043f! #\\u043a\\u0440\\u0430\\u0444\\u0442\\u044d\\u0442\\u043e\\u043b\\u044e\\u0431\\u043e\\u0432\\u044c\", \"created_time\": \"1501315471\", \"from\": {\"id\": \"261217117\", \"full_name\": \"bawka\", \"profile_picture\": \"https://scontent.cdninstagram.com/vp/f7565d17e113f6c9a4353adb06a42c47/5B363A7A/t51.2885-19/s150x150/17265847_1313699322044045_2293731892928708608_a.jpg\", \"username\": \"bawka1987\"}}, \"user_has_liked\": false, \"likes\": {\"count\": 44}, \"tags\": [\"\\u043a\\u0440\\u0430\\u0444\\u0442\\u044d\\u0442\\u043e\\u043b\\u044e\\u0431\\u043e\\u0432\\u044c\"], \"filter\": \"Normal\", \"comments\": {\"count\": 2}, \"type\": \"image\", \"link\": \"https://www.instagram.com/p/BXH4QC3BktWNY_eRtyzIi1MAAmo3f5SSwg2pas0/\", \"location\": null, \"attribution\": null, \"users_in_photo\": []}], \"meta\": {\"code\": 200}}";
//        System.out.println(userService.userExist(13));
//        System.out.println(userService.getToken(261217117));
//        for (String s:userService.getUserHashtags(261217117)
//             ) {
//            System.out.println(s);
//        }
//        System.out.println("MAIN: "+userService.getToken(261217117));
//        System.out.println(InstaService.getAuthUrl());
        JSONObject object = (JSONObject)JSONValue.parse(json);
        JSONArray jsonArray = (JSONArray)object.get("data");
        for(int i=0;i<jsonArray.size();i++)
        {
            object = (JSONObject)jsonArray.get(i);
            object = (JSONObject)object.get("images");
            object = (JSONObject)object.get("thumbnail");
            //object = (JSONObject)object.get("url");
            System.out.println(object.get("url").toString());
        }

        }

    }

