//
// Created by Anton Kasarin on 26/01/2026.
//

import SwiftUI
import Shared

import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCore

@MainActor
class ContentViewModel: ObservableObject {
    @Published var meals: Array<DishModel> = []

    func startObserving() async {
        do {
            meals = try await Greeting().fetchMeals()
        } catch {
            print("Failed with error: \(error)")
        }
    }
}