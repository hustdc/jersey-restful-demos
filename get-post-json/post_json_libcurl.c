#include <curl/curl.h>  
      
    int main(int argc, char *argv[])   
    {  
        char *szJsonData = "{\"name\":\"Agamemnon\",\"age\":32}"
    
            CURL *pCurl = NULL;  
            CURLcode res;  
            // In windows, this will init the winsock stuff  
            curl_global_init(CURL_GLOBAL_ALL);  
      
            // get a curl handle  
            pCurl = curl_easy_init();  
            if (NULL != pCurl)   
            {  
                // 设置超时时间为1秒  
                curl_easy_setopt(pCurl, CURLOPT_TIMEOUT, 1);  
      
                // First set the URL that is about to receive our POST.   
                // This URL can just as well be a   
                // https:// URL if that is what should receive the data.  
                curl_easy_setopt(pCurl, CURLOPT_URL, "http://192.168.0.2/posttest.svc");  
                //curl_easy_setopt(pCurl, CURLOPT_URL, "http://192.168.0.2/posttest.cgi");  
      
                // 设置http发送的内容类型为JSON  
                curl_slist *plist = curl_slist_append(NULL,   
                    "Content-Type:application/json;charset=UTF-8");  
                curl_easy_setopt(pCurl, CURLOPT_HTTPHEADER, plist);  
      
                // 设置要POST的JSON数据  
                curl_easy_setopt(pCurl, CURLOPT_POSTFIELDS, szJsonData);  
      
                // Perform the request, res will get the return code   
                res = curl_easy_perform(pCurl);  
                // Check for errors  
                if (res != CURLE_OK)   
                {  
                    printf("curl_easy_perform() failed:%s\n", curl_easy_strerror(res));  
                }  
                // always cleanup  
                curl_easy_cleanup(pCurl);  
            }  
            curl_global_cleanup();  
        }   
        return 0;  
    }  