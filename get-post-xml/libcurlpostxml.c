/*
* gcc -lcurl libcurlpostxml.c  -o libcurlpostxml
* ./libcurlpostxml  
 */
#include <stdio.h>
#include <curl/curl.h>
 
int main(void)
{
	CURL *curl;
        CURLcode res;
	char *post = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><transaction><transaction_header  lose some secury  </transaction>";

	char *url = "http://epos.yilian.com/ScoutAction!scoutAction.action";
	curl = curl_easy_init();
	  
	if(curl)
	  {
	    struct curl_slist *slist = NULL;
	  
	    slist = curl_slist_append(slist, "Accept: */*");
	    // slist = curl_slist_append(slist, "Content-Type: application/x-www-form-urlencoded");
	    slist = curl_slist_append(slist, "Content-Type: text/xml");
		
		
	    curl_easy_setopt(curl, CURLOPT_HTTPHEADER, slist);
	    curl_easy_setopt(curl, CURLOPT_VERBOSE, 1L);
	    curl_easy_setopt(curl, CURLOPT_HEADER, 0);
	    curl_easy_setopt(curl, CURLOPT_USERAGENT,  "Linux C  libcurl");
	    curl_easy_setopt(curl, CURLOPT_URL, url);
	    curl_easy_setopt(curl, CURLOPT_TIMEOUT, 30);
	    curl_easy_setopt(curl, CURLOPT_POSTFIELDS, post);
	    res = curl_easy_perform(curl);
	    curl_easy_cleanup(curl);
	    curl_slist_free_all(slist);
		
	}
	return 0;
}