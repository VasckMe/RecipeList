import SwiftUI
import Shared

import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCore

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        ListView(meals: viewModel.meals)
            .task { await self.viewModel.startObserving() }
    }
}

extension ContentView {
    @MainActor
    class ViewModel: ObservableObject {
        @Published var meals: Array<DishModel> = []

        func startObserving() async {
            do {
                meals = try await Greeting().fetchMeals()
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
}

struct ListView: View {
    var meals: Array<DishModel>

    var body: some View {
        List(meals, id: \.self) { meal in
            Text(meal.name)
            Text(meal.idString)
            Text(meal.thumbnailString)
        }
    }
}
