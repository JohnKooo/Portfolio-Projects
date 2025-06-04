const apiKey = `****`
const movieInput = document.querySelector("#movie-input")
const yearInput = document.querySelector("#year")
const button = document.querySelector("#search-movie")

const clearHtmlOldInfo = () => {

}


const userInput = () =>{
    // console.log("Movie" + movieInput.value)
    // console.log("Year" + yearInput.value)
    return [movieInput.value,yearInput.value]
}

const getMovieData = async (userSearch) => {
    const moviesSplit = userSearch[0].split(" ")
    const movieNameFormatted = moviesSplit.join("+")
    const response = await fetch(`http://www.omdbapi.com/?i=tt3896198&apikey=****=${movieNameFormatted}&y=${userSearch[1]}`)
    const data = await response.json()
    return data
}

const movieCritics = (movieData) => {
    const movieRatings = document.querySelector("#info")
    movieRatings.style = "visibility: visible;"
    movieRatings.innerHTML = "<h1>Critics</h1>"
    for (let i = 0; i < movieData.Ratings.length; i++) {
        // const element = array[i];
        
        const div = document.createElement('div')
        div.id = 'critics'
        const head = document.createElement('h1')
        const para = document.createElement('p')
        
        if (i == 0) {
            const div1 = document.createElement('div')
            div1.id = 'critics'
            const head1 = document.createElement('h1')
            const para1 = document.createElement('p')
            head1.textContent = "Metascore"
            para1.textContent =`Rating: ${movieData.Metascore}`
            div1.appendChild(head1)
            div1.appendChild(para1)
            movieRatings.appendChild(div1)

            const div2 = document.createElement('div')
            div2.id = 'critics'
            const head2 = document.createElement('h1')
            const para2 = document.createElement('p')
            head2.textContent = "IMDB"
            para2.textContent =`Rating: ${movieData.imdbRating}`
            div2.appendChild(head2)
            div2.appendChild(para2)
            movieRatings.appendChild(div2)
        }
        
        head.textContent = `${movieData.Ratings[i].Source}`
        para.textContent = `Rating: ${movieData.Ratings[i].Value}`

        div.appendChild(head)
        div.appendChild(para)
        movieRatings.appendChild(div)
    }
}

const movieOverallData = (movie) => {
    const movieAllInfo = document.querySelector("#all-info")
    movieAllInfo.innerHTML = ""
    const templete = `
    <h1>${movie.Title} <span id="m-year">-${movie.Year}</span> </h1>
            <ul>
                <li><span id="bring-out">Rated: </span>${movie.Rated}</li>
                <li><span id="bring-out">Released: </span>${movie.Released}</li>
                <li><span id="bring-out">Runtime: </span>${movie.Runtime}</li>
                <li><span id="bring-out">Genre: </span>${movie.Genre}</li>
                <li><span id="bring-out">Director: </span>${movie.Director}</li>
                <li><span id="bring-out">Writer: </span>${movie.Writer}</li>
                <li><span id="bring-out">Actors: </span>${movie.Actors}</li>
                <li><span id="bring-out">Plot:<br> </span>${movie.Plot}</li>
                <li><span id="bring-out">Language: </span>${movie.Language}</li>
                <li><span id="bring-out">Country: </span>${movie.Country}</li>
                <li><span id="bring-out">Awards: </span>${movie.Awards}</li>
            </ul>
    `
    movieAllInfo.innerHTML = templete
}

const extraMovieData = (movie) => {
    const movieExtraData = document.querySelector("#extra")
    movieExtraData.innerHTML = ""
    const templete = `
    <h4>Extra</h4>
        <p>
            imdbVotes: ${movie.imdbVotes},
            imdbID: ${movie.imdbID},
            Type: ${movie.Type},
            DVD: ${movie.DVD},
            BoxOffice: ${movie.BoxOffice},
            Production: ${movie.Production},
            Website: <a href="${movie.Website}">Click Me!</a>,
        </p>
    `
    movieExtraData.innerHTML = templete
}

const displayMovie = (movieData) => {
    // movieData.preventDefault()
    const moviePicture = document.querySelector("#movie-spot")
    moviePicture.src = movieData.Poster

    // making div elements then adding a h1 and p to them with info
    movieCritics(movieData)
    //data from title to awards method below
    movieOverallData(movieData)
    extraMovieData(movieData)
}


button.addEventListener("click", async (e) => {
    e.preventDefault()
    const userSearch = userInput();
    const movieData = await getMovieData(userSearch)
    clearHtmlOldInfo()
    displayMovie(movieData)
    // console.log(userSearch)
})


/**
 * {
    "Title": "The Maze Runner",
    "Year": "2014",
    "Rated": "PG-13",
    "Released": "19 Sep 2014",
    "Runtime": "113 min",
    "Genre": "Action, Mystery, Sci-Fi",
    "Director": "Wes Ball",
    "Writer": "Noah Oppenheim, Grant Pierce Myers, T.S. Nowlin",
    "Actors": "Dylan O'Brien, Kaya Scodelario, Will Poulter",
    "Plot": "Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow \"runners\" for a shot at escape.",
    "Language": "English",
    "Country": "United Kingdom, United States",
    "Awards": "4 wins & 12 nominations",
    "Poster": "https://m.media-amazon.com/images/M/MV5BMjUyNTA3MTAyM15BMl5BanBnXkFtZTgwOTEyMTkyMjE@._V1_SX300.jpg",
    "Ratings": [
        {
            "Source": "Internet Movie Database",
            "Value": "6.8/10"
        },
        {
            "Source": "Rotten Tomatoes",
            "Value": "65%"
        },
        {
            "Source": "Metacritic",
            "Value": "57/100"
        }
    ],
    "Metascore": "57",
    "imdbRating": "6.8",
    "imdbVotes": "493,182",
    "imdbID": "tt1790864",
    "Type": "movie",
    "DVD": "02 Dec 2014",
    "BoxOffice": "$102,427,862",
    "Production": "N/A",
    "Website": "N/A",
    "Response": "True"
}
 */