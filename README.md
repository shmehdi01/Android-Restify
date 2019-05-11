This library will help you to parse easily without any more efforts. 

Note : Make sure you have given INTERNET PERMISSION in manifest.xml

Step 1. Add the JitPack repository to your build file 

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	         implementation 'com.github.shmehdi01:Android-Restify:v.1.0.3'
	}

How to use ?

Suppose your JSON response us like that :

     {
       "facebook": "https://www.facebook.com/rizz.hacker",
       "twitter": "https://twitter.com/shmehdi01",
       "youtube": "https://www.youtube.com/shmehdi5",
     }

Create a Model/Pojo Class as :
     
      class Social {
     
        private String facebook;
        private String youtube;
        private String twitter;

        public String getFacebook() {
            return facebook;
        }

        public void setFacebook(String facebook) {
            this.facebook = facebook;
        }

        public String getYoutube() {
            return youtube;
        }

        public void setYoutube(String youtube) {
            this.youtube = youtube;
        }

        public String getTwitter() {
            return twitter;
        }

        public void setTwitter(String twitter) {
            this.twitter = twitter;
        }
    }

 
Hit request as :

       new Service<Social>().getRequest(this, url, new Parser<Social>() {
            @Override
            protected TypeToken<Social> parseJson() {
                return new TypeToken<Model>(){};
            }
        }, new Response<Social>() {
            @Override
            public void onServerResponse(Social social, String json, String url) {
                
            }
        });

More methods :
      postRequest()
      jsonReqeust()
      parseResponse()
      logError()
