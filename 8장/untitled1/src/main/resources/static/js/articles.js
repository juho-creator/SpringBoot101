const deleteBtn = document.getElementById('delete-btn');


if(deleteBtn){
    deleteBtn.addEventListener('click', event=>{
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        }).then(()=>{
            alert('Article has been deleted');
            location.replace('/articles');
        })
    })
}


const updateBtn = document.getElementById('update-btn');

if(updateBtn){
    updateBtn.addEventListener('click', event=>{
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
               'Content-Type' : 'application/json'
            },
            body : JSON.stringify({
                'title' : document.getElementById('article-title').value,
                'content' : document.getElementById('article-content').value
            })
        }).then(()=>{
            alert('Article has been updated');
            location.replace('/articles');
        })
    })
}


const createBtn = document.getElementById('create-btn');

if(createBtn){
    createBtn.addEventListener('click', event=>{
        fetch(`/api/articles`, {
            method: 'POST',
            headers: {
               'Content-Type' : 'application/json'
            },
            body : JSON.stringify({
                'title' : document.getElementById('article-title').value,
                'content' : document.getElementById('article-content').value
            })
        }).then(()=>{
            alert('Article has been created');
            location.replace('/articles');
        })
    })
}