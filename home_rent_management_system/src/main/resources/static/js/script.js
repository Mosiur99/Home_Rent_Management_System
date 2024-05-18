function submitReview() {
    var email = document.getElementById('email').value;
    var comment = document.getElementById('comment').value;
    var userName = document.getElementById('userName').value;

    addReview(email, comment, userName);
}

function addReview(email, comment, userName) {
    var xhtr = new XMLHttpRequest();
    xhtr.open('POST', '/add-review', true);

    var formData = new FormData();
    formData.append('email', email);
    formData.append('comment', comment);
    formData.append('userName', userName);

    xhtr.onload = function () {
        if (xhtr.status === 200) {
            alert("Review successfully added.");
        } else {
            alert("Failed to add review. Status: " + xhtr.status);
        }
    };

    xhtr.onerror = function () {
        alert("An error occurred during the transaction.");
    };

    xhtr.send(formData);
}

function getReviews() {
    var xhtr = new XMLHttpRequest();
    xhtr.open('POST', '/get-reviews', true);
    xhtr.onload = function () {
        if (xhtr.status === 200) {
            var reviews = JSON.parse(xhtr.responseText);
            var reviewList = document.getElementById('reviewList');
            reviewList.innerText = '';
            for(var i in reviews){
                var review = document.createElement('li');
                var name = document.createElement('p');
                name.innerText = reviews[i].userName;
                review.appendChild(name);
                reviewList.appendChild(review);
                var comment = document.createElement('p');
                comment.innerText = reviews[i].comment;
                review.appendChild(comment);
                reviewList.appendChild(review);
            }
            var reviewList = document.getElementById('reviewList');
            if(reviewList.style.display === 'block'){
                reviewList.style.display = 'none';
            }else{
                reviewList.style.display = 'block';
             }
        } else {
            alert("An error occurred during the transaction.");
        }
    };
    xhtr.send();
}