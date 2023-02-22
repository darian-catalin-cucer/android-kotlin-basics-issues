// This code demonstrates using Git issues in a Kotlin project

fun main() {
    val issue = GitIssue("#1234", "Update README with new examples", "johndoe")
    val comment1 = GitComment("Looks good to me", "janedoe")
    val comment2 = GitComment("I found a typo in the third paragraph", "jimmy")
    
    issue.addComment(comment1)
    issue.addComment(comment2)
    
    println(issue)
}

class GitIssue(val number: String, val title: String, val author: String) {
    val comments = mutableListOf<GitComment>()
    
    fun addComment(comment: GitComment) {
        comments.add(comment)
    }
    
    override fun toString(): String {
        var output = "Issue $number: $title\n"
        output += "Author: $author\n"
        output += "Comments:\n"
        for (comment in comments) {
            output += "\t${comment.author}: ${comment.text}\n"
        }
        return output
    }
}

class GitComment(val text: String, val author: String)
