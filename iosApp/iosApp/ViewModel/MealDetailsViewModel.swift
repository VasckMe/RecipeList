//
// Created by Anton Kasarin on 26/01/2026.
//

import SwiftUI
import Shared

import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCore

@MainActor
class MealDetailsViewModel: ObservableObject {
    @Published var detailsModel: DishDetails? = nil

    let id: String

    init(id: String) {
        self.id = id
    }

    func fetchDetails() async {
        do {
            detailsModel = try await Greeting().fetchDishDetails(dishID: id)
        } catch {
            print("Failed with error: \(error)")
        }
    }
}
