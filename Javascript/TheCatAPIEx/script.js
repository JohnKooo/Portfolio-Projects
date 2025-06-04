//storing API in plane text on client
const apiKey = '****'

//finding html elements
const breedSelect = document.querySelector("#breedSelect")
const button = document.querySelector("#fetchCatButton")
const catImageContainer = document.querySelector("#catImageContainer")

const populateBreedDropdown = async () => {
    // call the api to get breeds
    const response = await fetch('https://api.thecatapi.com/v1/breeds',{
        headers: {
            'x-api-key': apiKey
        }
    })
    //fill dropdown menu
    const breeds = await response.json()
    breeds.forEach(breed => {
        //create option html element
        const option = document.createElement('option')
        //assign data to element
        option.value = breed.id
        option.textContent = breed.name
        //add new option to select
        breedSelect.appendChild(option)
    });
}

const fetchCatImage = async (e) => {
    e.preventDefault()
    const selectedBreed = breedSelect.value
    console.log(selectedBreed)
    const response = await fetch(`https://api.thecatapi.com/v1/images/search?breed_ids=${selectedBreed}`,
    {
        headers: {
            'x-api-key': apiKey
        }
    })
    const catData = await response.json()
    const catImageUrl = catData[0].url
    const image = document.createElement(`img`)
    image.src = catImageUrl
    catImageContainer.innerHTML = ``
    catImageContainer.appendChild(image)
}

button.addEventListener("click", fetchCatImage)

populateBreedDropdown();
