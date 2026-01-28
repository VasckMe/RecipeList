package viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipelist.Greeting
import com.example.recipelist.Model.DishModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

open class MainViewModel : ViewModel() {
    private val _mealList = MutableStateFlow<List<DishModel>>(listOf())
    val mealList: StateFlow<List<DishModel>> get() = _mealList

    init {
        viewModelScope.launch {
            _mealList.update { Greeting().fetchMeals() }
        }
    }
}