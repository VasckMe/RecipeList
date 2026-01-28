package viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipelist.Greeting
import com.example.recipelist.Model.DishDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealDetailsViewModel: ViewModel() {

    private val _detailsModel = MutableStateFlow<DishDetails?>(null)
    val detailsModel = _detailsModel.asStateFlow()

    fun fetchDetails(id: String) {
        viewModelScope.launch {
            try {
                val result = Greeting().fetchDishDetails(dishID = id)
                _detailsModel.value = result
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}