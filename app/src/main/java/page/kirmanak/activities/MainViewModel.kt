package page.kirmanak.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: BoredRepository = BoredRepositoryImpl()

    private val stateFlow = MutableStateFlow(MainState())
    val state = stateFlow.asStateFlow()

    fun onActivityRequested() {
        viewModelScope.launch {
            val response: BoredActivityResponse = repository.getActivity(null, null)
            stateFlow.value = MainState(response.activity)
        }
    }
}

data class MainState(
    val activity: String? = null,
)