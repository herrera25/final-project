import java.util.Scanner;

public class Engine {

  // instance variables
  private String[] mentions = new String[140];
  private String[] topics = new String[140];
  private String[] urls = new String[140];




  // print twitter message
  public String getMessage(String message) {
      System.out.println();
      System.out.println(message);
      return message;
  }

  // check tweet length
  public boolean isCorrectLength(String message) {
      boolean flag = false;

      if (message.length() > 280) {
            System.out.println();
            System.out.println("Tweet length exceeds 280 characters.");
            System.exit(0);
      }
      else
          flag = true;

      return flag;
    }


  // detects mentions in tweet
  // mentions must come at the beginning of a tweet and be separated by spaces
  public String[] detectMentions(String message) {

          // index variables
          int atIndex = message.indexOf('@');
          int spaceIndex = message.indexOf(' ');
          int x = 0;

          if (atIndex != -1) {
              while ((atIndex >= 0) && (spaceIndex < message.length())) {
                  // normal tweet case
                  if ((atIndex < spaceIndex) || (spaceIndex == -1)) {
                      if (spaceIndex != -1) {
                          mentions[x] = (message.substring(atIndex, spaceIndex));
                          atIndex = message.indexOf('@', atIndex + 1);
                          spaceIndex = message.indexOf(' ', spaceIndex + 1);
                          x++;
                      } else {  // allows for a single mention as a tweet
                          mentions[x] = (message.substring(atIndex, message.length()));
                          atIndex = message.indexOf('@', atIndex + 1);
                          x++;
                      }
                  } else {
                      spaceIndex = message.indexOf(' ', spaceIndex + 1);
                      // System.out.println(spaceIndex);
                  }
              }
          }


          // prints each mention
          if (mentions[0] != null) {
              System.out.println();
              System.out.println("Tweet Mentions:");
          }

          for (int i = 0; i < mentions.length; i++) {
              if (mentions[i] != null)
                  System.out.println(mentions[i]);
          }
          return mentions;
      }


  // detects topics in tweet
  public String[] detectTopics(String message) {

          // index variables
          int hashtagIndex = message.indexOf('#');
          int spaceIndex = message.indexOf(' ');
          int x = 0;

          if (hashtagIndex != -1) {
              while ((hashtagIndex >= 0) && (spaceIndex < message.length())) {
                  // normal tweet case
                  if ((hashtagIndex < spaceIndex) || (spaceIndex == -1)) {
                      if (spaceIndex != -1) {
                          topics[x] = (message.substring(hashtagIndex, spaceIndex));
                          hashtagIndex = message.indexOf('#', hashtagIndex + 1);
                          spaceIndex = message.indexOf(' ', spaceIndex + 1);
                          x++;
                      } else {  // allows for a single topic as a tweet
                          topics[x] = (message.substring(hashtagIndex, message.length()));
                          hashtagIndex = message.indexOf('#', hashtagIndex + 1);
                          x++;
                      }
                  } else {
                      spaceIndex = message.indexOf(' ', spaceIndex + 1);
                      // System.out.println(spaceIndex);
                  }
              }
          }

          // prints each topic
          if (topics[0] != null) {
              System.out.println();
              System.out.println("Tweet Topics:");
          }

          for (int i = 0; i < mentions.length; i++) {
              if (topics[i] != null)
                  System.out.println(topics[i]);
          }
          return topics;
      }


  // detects urls in tweet
  public String[] detectUrls(String message) {

          // index variables
          int wwwIndex = message.indexOf("www.");
          int spaceIndex = message.indexOf(' ');
          int x = 0;

          if (wwwIndex != -1) {
              while ((wwwIndex >= 0) && (spaceIndex < message.length())) {
                  // normal tweet case
                  if ((wwwIndex < spaceIndex) || (spaceIndex == -1)) {
                      if (spaceIndex != -1) {
                          urls[x] = (message.substring(wwwIndex, spaceIndex));
                          wwwIndex = message.indexOf("www.", wwwIndex + 1);
                          spaceIndex = message.indexOf(' ', spaceIndex + 1);
                          x++;
                      } else {  // allows for a single url as a tweet
                          urls[x] = (message.substring(wwwIndex, message.length()));
                          wwwIndex = message.indexOf("www.", wwwIndex + 1);
                          x++;
                      }
                  } else {
                      spaceIndex = message.indexOf(' ', spaceIndex + 1);
                      // System.out.println(spaceIndex);
                  }
              }
          }

          // prints each url
          if (urls[0] != null) {
              System.out.println();
              System.out.println("Tweet URLs:");
          }

          for (int i = 0; i < mentions.length; i++) {
              if (urls[i] != null)
                  System.out.println(urls[i]);
          }
          return urls;
      }



  // test method (for use before test class)
  public static void main(String[] args) {
    Engine myObject = new Engine();
    String myMessage;
    Scanner scan = new Scanner(System.in);

    System.out.println("Message:");
    myMessage = scan.nextLine();

    myObject.isCorrectLength(myMessage);
    myObject.getMessage(myMessage);
    myObject.detectMentions(myMessage);
    myObject.detectTopics(myMessage);
    myObject.detectUrls(myMessage);
  }
}