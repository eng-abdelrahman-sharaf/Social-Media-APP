# Social-Media-APP
## Feature workflow
- Follow the pdf requirments
- Validate all input fields
- Handle possible errors and notify the user
- Follow SOLID Principles
- Make sure no repetition occured
- check you followed the json format

## To learn
- basic git commands commit, add , pull, push, checkout, branch
- how to make a pull request
- how to review a pull request
- SOLID principles
- different diagrams


## Important Notes
- Create branches for tasks (e.g., feature-login, feature-profile-update).
- After ending the feature make a pull request
- Work on a seperate file in order to minimize conflicts as much as possible
- Submit pull requests for review before merging changes.
- Each pull request should be reviewed by at least one team member.

## User JSON format
```json
{
"userID": "user123",
"friendsIDs": ["user456", "user789", "user101"],
"postsIDs": ["post001", "post002"],
"BIO": "Just another tech enthusiast exploring the world!",
"hashedPassword": "5f4dcc3b5aa765d61d8327deb882cf99", 
"status": "Active",
"email": "user123@example.com",
"dateOfBirth": "1990-05-15",
"profilePhotoPath": "/images/profile123.jpg",
"coverPhotoPath": "/images/cover123.jpg",
"storiesIDs": ["story001", "story002"]
}
```


## Content (whose children are Post or Story) JSON format

```json
{
  "contentID": "story001",
  "authorId": "user123",
  "content": {
    "text": "Had a great day coding with friends! #TechLife",
    "imagePaths": ["/images/story001_1.jpg", "/images/story001_2.jpg"],
    "timestamp": "2024-12-01T10:30:00Z"
  }
}
```
