package leon.training.function.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiaolong on 2017/6/5.
 */

public class GsonBean {


    /**
     * current_user_url : https://api.github.com/user
     * current_user_authorizations_html_url : https://github.com/settings/connections/applications{/client_id}
     * authorizations_url : https://api.github.com/authorizations
     * code_search_url : https://api.github.com/search/code?q={query}{&page,per_page,sort,order}
     * commit_search_url : https://api.github.com/search/commits?q={query}{&page,per_page,sort,order}
     * emails_url : https://api.github.com/user/emails
     * emojis_url : https://api.github.com/emojis
     * events_url : https://api.github.com/events
     * feeds_url : https://api.github.com/feeds
     * followers_url : https://api.github.com/user/followers
     * following_url : https://api.github.com/user/following{/target}
     * gists_url : https://api.github.com/gists{/gist_id}
     * hub_url : https://api.github.com/hub
     * issue_search_url : https://api.github.com/search/issues?q={query}{&page,per_page,sort,order}
     * issues_url : https://api.github.com/issues
     * keys_url : https://api.github.com/user/keys
     * notifications_url : https://api.github.com/notifications
     * organization_repositories_url : https://api.github.com/orgs/{org}/repos{?type,page,per_page,sort}
     * organization_url : https://api.github.com/orgs/{org}
     * public_gists_url : https://api.github.com/gists/public
     * rate_limit_url : https://api.github.com/rate_limit
     * repository_url : https://api.github.com/repos/{owner}/{repo}
     * repository_search_url : https://api.github.com/search/repositories?q={query}{&page,per_page,sort,order}
     * current_user_repositories_url : https://api.github.com/user/repos{?type,page,per_page,sort}
     * starred_url : https://api.github.com/user/starred{/owner}{/repo}
     * starred_gists_url : https://api.github.com/gists/starred
     * team_url : https://api.github.com/teams
     * user_url : https://api.github.com/users/{user}
     * user_organizations_url : https://api.github.com/user/orgs
     * user_repositories_url : https://api.github.com/users/{user}/repos{?type,page,per_page,sort}
     * user_search_url : https://api.github.com/search/users?q={query}{&page,per_page,sort,order}
     */

    @SerializedName("current_user_url")
    public String currentUserUrl;
    @SerializedName("current_user_authorizations_html_url")
    public String currentUserAuthorizationsHtmlUrl;
    @SerializedName("authorizations_url")
    public String authorizationsUrl;
    @SerializedName("code_search_url")
    public String codeSearchUrl;
    @SerializedName("commit_search_url")
    public String commitSearchUrl;
    @SerializedName("emails_url")
    public String emailsUrl;
    @SerializedName("emojis_url")
    public String emojisUrl;
    @SerializedName("events_url")
    public String eventsUrl;
    @SerializedName("feeds_url")
    public String feedsUrl;
    @SerializedName("followers_url")
    public String followersUrl;
    @SerializedName("following_url")
    public String followingUrl;
    @SerializedName("gists_url")
    public String gistsUrl;
    @SerializedName("hub_url")
    public String hubUrl;
    @SerializedName("issue_search_url")
    public String issueSearchUrl;
    @SerializedName("issues_url")
    public String issuesUrl;
    @SerializedName("keys_url")
    public String keysUrl;
    @SerializedName("notifications_url")
    public String notificationsUrl;
    @SerializedName("organization_repositories_url")
    public String organizationRepositoriesUrl;
    @SerializedName("organization_url")
    public String organizationUrl;
    @SerializedName("public_gists_url")
    public String publicGistsUrl;
    @SerializedName("rate_limit_url")
    public String rateLimitUrl;
    @SerializedName("repository_url")
    public String repositoryUrl;
    @SerializedName("repository_search_url")
    public String repositorySearchUrl;
    @SerializedName("current_user_repositories_url")
    public String currentUserRepositoriesUrl;
    @SerializedName("starred_url")
    public String starredUrl;
    @SerializedName("starred_gists_url")
    public String starredGistsUrl;
    @SerializedName("team_url")
    public String teamUrl;
    @SerializedName("user_url")
    public String userUrl;
    @SerializedName("user_organizations_url")
    public String userOrganizationsUrl;
    @SerializedName("user_repositories_url")
    public String userRepositoriesUrl;
    @SerializedName("user_search_url")
    public String userSearchUrl;


    @Override
    public String toString() {
        return "GsonBean{" +
                "currentUserUrl='" + currentUserUrl + '\'' +
                ", currentUserAuthorizationsHtmlUrl='" + currentUserAuthorizationsHtmlUrl + '\'' +
                ", authorizationsUrl='" + authorizationsUrl + '\'' +
                ", codeSearchUrl='" + codeSearchUrl + '\'' +
                ", commitSearchUrl='" + commitSearchUrl + '\'' +
                ", emailsUrl='" + emailsUrl + '\'' +
                ", emojisUrl='" + emojisUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", feedsUrl='" + feedsUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                ", followingUrl='" + followingUrl + '\'' +
                ", gistsUrl='" + gistsUrl + '\'' +
                ", hubUrl='" + hubUrl + '\'' +
                ", issueSearchUrl='" + issueSearchUrl + '\'' +
                ", issuesUrl='" + issuesUrl + '\'' +
                ", keysUrl='" + keysUrl + '\'' +
                ", notificationsUrl='" + notificationsUrl + '\'' +
                ", organizationRepositoriesUrl='" + organizationRepositoriesUrl + '\'' +
                ", organizationUrl='" + organizationUrl + '\'' +
                ", publicGistsUrl='" + publicGistsUrl + '\'' +
                ", rateLimitUrl='" + rateLimitUrl + '\'' +
                ", repositoryUrl='" + repositoryUrl + '\'' +
                ", repositorySearchUrl='" + repositorySearchUrl + '\'' +
                ", currentUserRepositoriesUrl='" + currentUserRepositoriesUrl + '\'' +
                ", starredUrl='" + starredUrl + '\'' +
                ", starredGistsUrl='" + starredGistsUrl + '\'' +
                ", teamUrl='" + teamUrl + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", userOrganizationsUrl='" + userOrganizationsUrl + '\'' +
                ", userRepositoriesUrl='" + userRepositoriesUrl + '\'' +
                ", userSearchUrl='" + userSearchUrl + '\'' +
                '}';
    }
}
