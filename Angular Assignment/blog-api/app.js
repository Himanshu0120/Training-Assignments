const http=require('http');
const express=require('express');
var cors = require('cors')
var app = express()

app.use(cors())
app.use(express.json())
const sql=require('mysql');
const { title } = require('process');
const { json } = require('express');
const connection=sql.createConnection({
    host: "localhost",
    user: "root",
    port: "3306",
    database: "blogs",
    password: "root"
})
connection.connect((err)=> {
    if(!err)
    console.log('Connection Established Successfully');
    else
    console.log('Connection Failed!'+ JSON.stringify(err,undefined,2));
    });







app.get('/api/blogs',(req,res)=>{
    connection.query('select * from blog',(err,data)=>{
        if(!err){
           
            res.send(data);
            return
        }
})
})

app.get('/api/blogs/:id',(req,res)=>{
    let id=req.params.id;
    connection.query(`select * from blog where id=${id}`,(err,data)=>{
        results=JSON.parse(JSON.stringify(data))
        

        res.send(results[0])
        return
    })
    
})

app.post('/api/blogs',(req,res)=>{
    let title=req.body.title;
    let content=req.body.content;
    connection.query(`INSERT INTO blog(title,content) VALUES ("${title}","${content}");`, (err, rows, fields) => {
        if (!err)
        res.send(title)
        else
        return
        })
})

app.put('/api/blogs/:id',(req,res)=>{
    let id=req.params.id;
    let title=req.body.title;
    let content=req.body.content;
    connection.query(`update blog set title="${title}",content="${content}" where id=${id};`,(err,result)=>{
        if(err)
        console.log(err);
        res.send("updated")
        return
    })
})

app.delete('/api/blogs/:id',(req,res)=>{
    let id=req.params.id;
    
    connection.query("delete from blog where id=?",[id],(err,result)=>{
        res.send("deleted")
        return
    })
})


app.listen(3000)