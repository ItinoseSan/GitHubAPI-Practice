package github.system;

import github.json.JsonDecodeForScore;
import github.net.GitHubHttpRequest;

public class GitHubScore
{
  private String api_github_endpointUrl="https://api.github.com/";

  public String getScore(String username){
      String requestUrl=api_github_endpointUrl+"users/"+username+"/repos";

      GitHubHttpRequest request=new GitHubHttpRequest();
      String repositoryInfo=request.get(requestUrl);
      try{
         JsonDecodeForScore decodeForScore=new JsonDecodeForScore();
         decodeForScore.decode(repositoryInfo);
         return username;
      }
      catch (Exception e){
         return e.toString();
      }
  }
}
